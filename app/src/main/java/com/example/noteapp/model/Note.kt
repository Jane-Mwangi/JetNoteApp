import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashMap

data class Note @RequiresApi(Build.VERSION_CODES.O) constructor(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        private val entryDates = HashMap<UUID, LocalDateTime>()

        fun getEntryDate(note: Note): LocalDateTime {
            return entryDates[note.id] ?: note.entryDate
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun setEntryDate(note: Note, entryDate: LocalDateTime) {
            entryDates[note.id] = entryDate
        }
    }
}
