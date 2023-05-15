import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashMap

@Entity(tableName = "notes_tbl")
data class Note  @RequiresApi(Build.VERSION_CODES.O) constructor(
    @PrimaryKey //annotations
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,
    @ColumnInfo(name = "note_entry")
    val entryDate: Date = Date.from(Instant.now())
        )
//) {
//    companion object {
//        private val entryDates = HashMap<UUID, LocalDateTime>()
//
//        fun getEntryDate(note: Note): Date {
//            return entryDates[note.id] ?: note.entryDate
//        }
//
//        @RequiresApi(Build.VERSION_CODES.O)
//        fun setEntryDate(note: Note, entryDate: LocalDateTime) {
//            entryDates[note.id] = entryDate
//        }
//    }
//}
