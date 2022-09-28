package test.karpenko.callbackandviewtype.models

class Dog(override val name: String, override val isFlying: Boolean) : Animal(name, isFlying) {
    override fun voice(): String {
        return "Wof-wof"
    }


}