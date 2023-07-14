package com.example.fastcampusandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.REPLACE

class RoomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        // 기본적으로 데이터베이스 작업은 메인 쓰레드에서 할 수 없다
        // 이유 -> 데이터베이스 작업을 휴대폰이 하는동안 사용자가 기다려야하기때문
        // 해결책 -> 쓰레드를 이용하고 async를 이용하면 된다.
        val database =
            Room.databaseBuilder(applicationContext, UserDatabase::class.java, "user-database")
                .allowMainThreadQueries().build()

        findViewById<TextView>(R.id.save).setOnClickListener {
            val user = User("홍", "길동")
            database.userDao().insert(user)
        }
        findViewById<TextView>(R.id.load).setOnClickListener {
            val users = database.userDao().getAll()
            users.forEach {
                Log.d("testt", "" + it.id + it.firstName)
            }
        }
        findViewById<TextView>(R.id.delete).setOnClickListener {
            database.userDao().delete(1)
        }
        findViewById<TextView>(R.id.deleteAll).setOnClickListener {
            database.userDao().deleteAll()
        }
    }
}

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDAO
}

@Dao
interface UserDAO {
    // CRUD -> 데이터 베이스 조작
    // Query -> 데이터 베이스 조회
    @Insert(onConflict = REPLACE)
    fun insert(user: User)

    @Query("DELETE FROM user WHERE id = :userId")
    fun delete(userId: Int)

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("DELETE FROM user")
    fun deleteAll()
}

@Entity
class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "first_name")
    val firstName: String
) {
    constructor(lastName: String, firstName: String) : this(0, lastName, firstName)
    // 부생성자를 통해 주생성자의 PrimaryKey값을 직접적으로 넣지 않고 등록하게 설정
}

