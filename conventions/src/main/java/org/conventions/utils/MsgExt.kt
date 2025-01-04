package org.conventions.utils

import org.conventions.utils.Constant.GLOBAL_TAG

/**
 * Designed and developed by Herlangga Wicaksono on 02/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
fun printMessage(
	msg: String,
	showIntentional: Boolean = false,
) {
	println("$GLOBAL_TAG $msg")
	if (showIntentional) intentionalMessage()
}

fun intentionalMessage() {
	println("$GLOBAL_TAG if this is intentional then you may skip this message")
}