import WorkHome.Keychat
import WorkHome.Message
import WorkHome.Service

fun main() {
    val user = Service()
    // создаем аккаунт разделяющий разных пользователей
    val account: Int = 1
    // создаются чаты
    val chat1 = Keychat()
    val chat2 = Keychat()
    user.createChat(chat1)
    user.createChat(chat2)
    // создаются сообщения
    val message1 = Message(textMessage = "Первый")
    val message2 = Message(textMessage = "Второй")
    val message3 = Message(textMessage = "Третий")
    val message4 = Message(textMessage = "Четвертый")
    // добавляются сообщения в чат 1 в процесс
    user.add(listOf(account, chat1.id), message1)
    user.add(listOf(account, chat1.id), message2)
    // добавляются сообщения в чат 2 в процесс
    user.add(listOf(account, chat2.id), message3)
    user.add(listOf(account, chat2.id), message4)
    // Использование extension функций
    message1.reads()
    message2.reads()
    message3.deleteMessage()
    //println(user.returnMessage(chat1))
    println("1")
    println(user.returnMessage2(account, chat1))
    println(user.returnMessage2(account, chat2))
    user.deleteChat(account,chat1)
    //println(user.returnMessage(chat2))
    println("2")
    println(user.returnMessage2(account, chat1))
    user.returnChat(chat2)
    println(user.getUnreadMessage(account, chat2))
}
   // создание 2-ух extension функций
private fun Message.reads() {
    apply {
        readMessage = true
    }
}
private fun Message.deleteMessage() {
    apply {
        stateMessage = false
    }
}






