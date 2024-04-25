package com.github.chengzis.bom.pom

import org.dom4j.Branch

interface IDocument {

    fun build(branch: Branch)
}