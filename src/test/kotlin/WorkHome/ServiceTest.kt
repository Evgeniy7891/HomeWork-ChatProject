package WorkHome

import org.junit.Test

import org.junit.Assert.*

class ServiceTest {

    @Test
    fun getGenetatedIdChatAndCreateTest() {
        val test = Service()
        val chatTest1 = Keychat()
        val chatTest2 = Keychat()
        val chatTest3 = Keychat()
        test.createChat(chatTest1)
        test.createChat(chatTest2)
        val result = test.createChat(chatTest3)
        assertEquals(3, result)
    }

    @Test
    fun createMessageTest() {
        val test = Service()
        val messageTest = Message()
        val result = test.createMessage(messageTest)
        val expected = Message(idMessage = 1)
        assertEquals(expected, result)
    }

    @Test
    fun addTest() {
        val test = Service()
        val accountTest = 1
        val chatTest1 = Keychat()
        val messageTest = Message()
        val result = test.add(listOf(accountTest, chatTest1.id), messageTest)
        assertNotNull(result)
    }

    @Test
    fun returnChatTest() {
        val test = Service()
        val chatTest1 = Keychat()
        val result = test.returnChat(chatTest1)
        assertTrue(result)
    }

    @Test
    fun getUnreadMessageTest() {
        val test = Service()
        val accountTest = 1
        val chatTest1 = Keychat()
        val messageTest = Message()
        val messageTest2 = Message()
        test.add(listOf(accountTest,chatTest1.id),messageTest)
        test.add(listOf(accountTest,chatTest1.id),messageTest2)
        val result = test.getUnreadMessage(accountTest, chatTest1)
        assertEquals(2, result)

    }
}