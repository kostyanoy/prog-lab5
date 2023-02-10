package commands

abstract class Command(val name: String) {
    abstract fun execute()
}