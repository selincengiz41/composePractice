package com.selincengiz.composepractice.ktlint_ruleset

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider
import com.selincengiz.composepractice.ktlint_ruleset.NoBlankLinesInWhenRule

class MyCustomRuleSetProvider : RuleSetProvider {
    override fun get() = RuleSet("my-custom-rules", NoBlankLinesInWhenRule())
}
