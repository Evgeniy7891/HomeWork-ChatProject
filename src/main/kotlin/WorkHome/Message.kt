package WorkHome

// дата класс сообщений
data class Message(
    var idMessage: Int = 0, // айди сообщений
    val idOwner: Int = 0,
    var textMessage: String = " ",
    var readMessage: Boolean = false, // флажок что сообщений прочитанно - false - сообщение не прочитанно
    var stateMessage: Boolean = true, // флажок что состояние сообщения - true - сообщение положительное, не удаленно
    var like: Int = 0
) {
    val messages: MutableList<Message> = mutableListOf() // создаем внутри класса коллекцию из пустого списка

    override fun toString(): String {
        return "Message(idMessage=$idMessage, idOwner=$idOwner, textMessage='$textMessage', readMessage=$readMessage, stateMessage=$stateMessage)"
    }

}
