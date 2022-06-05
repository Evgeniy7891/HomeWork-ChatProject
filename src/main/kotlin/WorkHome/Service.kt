package WorkHome

// создаем класс Сервис с функциями
class Service {
    val base = hashMapOf<List<Int>, Message>() // создаем базу сообщений с ключами из аккаунта пользователя и айди чата

    var genetatedIdChat = 1 // генерирует айди для чатов
    var generatedMessageId: Int = 1 // генерирует айди для сообщений

    // генерируем для чатов свой айди
    fun createChat(name: Keychat): Int {
        name.id = genetatedIdChat++
        return name.id
    }

    // генерируем для сообщений свой айди
    fun createMessage(name: Message): Message {
        name.idMessage = generatedMessageId++
        return name
    }

    // функция добавления сообщения
    fun add(key: List<Int>, name: Message): Message {
        createMessage(name)
        return base.getOrPut(key) {
            name
        }.apply {
            messages.add(name)
        }
    }

    // функция получения списка сообщений без проверки что сообщение удаленно или нет
    fun returnMessage(key: Keychat): List<Message> {
        val result = base.filter { entry -> entry.key == listOf(key) }.values.first().messages
        return result
    }

    // функция получения списка сообщений вариант 2
    fun returnMessage2(account: Int, key: Keychat): List<Message> {
        return base.getValue(listOf(account, key.id)).messages.filter { it -> it.stateMessage == true }
    }

    // получения чатов
    fun returnChat(key: Keychat): Boolean {
        if (key.stateChat == true) {
            println(key)
            return true
        } else {
            return false
        }
    }

    // функция удаления чатов и сообщений принадлежавшие этому чату
    fun deleteChat(account: Int, key: Keychat) {
        base.filter { base -> listOf(base.key) == listOf(account, key.id) && key.stateChat == true }
        key.stateChat = false
        for (elem in returnMessage2(account, key)) {
            elem.stateMessage = false
        }
    }
    // получения количества не прочитанных сообшений
    fun getUnreadMessage(account: Int, key: Keychat): Int {
        return returnMessage2(account, key).filter { it -> it.readMessage == false }.count()
    }
}



