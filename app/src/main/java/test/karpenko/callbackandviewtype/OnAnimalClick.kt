package test.karpenko.callbackandviewtype

import test.karpenko.callbackandviewtype.models.Animal

interface OnAnimalClick {
    fun onAnimalClickExclamationListener(animal: Animal)
}
