package test.karpenko.callbackandviewtype.models

class Cat(name: String, isFlying: Boolean) : Animal(name, isFlying) {
    override fun voice(): String {
        return "Moew-moew"
    }
}