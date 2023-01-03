package com.uc.chalk.helper

const val DATE_MASK = "##/##/####"
const val DATE_LENGTH = 8 // Equals to "##/##/####".count { it == '#' }

//class MaskVisualTransformation(private val mask: String): VisualTransformation {
//    private val specialSymbolsIndices = mask.indices.filter { mask[it] != '#' }
//
//    override fun filter(text: AnnotatedString): TransformedText {
//        var out = ""
//        var maskIndex = 0
//        text.forEach { char ->
//            while (specialSymbolsIndices.contains(maskIndex)) {
//                out += mask[maskIndex]
//                maskIndex++
//            }
//            out += char
//            maskIndex++
//        }
//        return TransformedText(AnnotatedString(out), offsetTranslator())
//    }
//
//    private fun offsetTranslator() = object : OffsetMapping {
//        override fun originalToTransformed(offset: Int): Int {
//            val offsetValue = offset.absoluteValue
//            if (offsetValue == 0) return 0
//            var numberOfHashtags = 0
//            val masked = mask.takeWhile {
//                if (it == '#') numberOfHashtags++
//                numberOfHashtags < offsetValue
//            }
//            return masked.length + 1
//        }
//
//        override fun transformedToOriginal(offset: Int): Int {
//            return mask.take(offset.absoluteValue).count { it == '#' }
//        }
//    }
//}

