package test.karpenko.callbackandviewtype.models

class Sparrow(name: String, isFlying: Boolean) : Animal(name, isFlying) {
    override fun voice(): String {
        return "tetter"
    }


}