package WorkHome
// класс чат
class Keychat(
    var id: Int = 0, // чат со своим айди
    var stateChat: Boolean = true // флажок состояния чата - true - чат, не удаленн
) {
    override fun toString(): String {
        return "WorkHome.Keychat(idChat=$id stateChat=$stateChat)"
    }
}