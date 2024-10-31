package com.selincengiz.composepractice.ktlint_ruleset

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.ElementType
import com.pinterest.ktlint.core.ast.prevLeaf
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

class NoBlankLinesInWhenRule : Rule("no-blank-lines-in-when") {
    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == ElementType.WHEN_ENTRY) {
            val prevLeaf = node.prevLeaf()
            if (prevLeaf != null && prevLeaf.elementType == ElementType.WHITE_SPACE && prevLeaf.textContains('\n')) {
                emit(node.startOffset, "Blank lines are not allowed within when block",true)
                if (autoCorrect) {
                    prevLeaf.treeParent.removeChild(prevLeaf)
                }
            }
        }
    }
}
