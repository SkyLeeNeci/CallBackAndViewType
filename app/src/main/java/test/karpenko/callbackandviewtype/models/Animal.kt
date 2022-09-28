package test.karpenko.callbackandviewtype.models

abstract class Animal(open val name: String, open val isFlying: Boolean) {

 abstract fun voice(): String

}