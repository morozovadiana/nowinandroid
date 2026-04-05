/*
 * Copyright 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.lesson16

import androidx.compose.ui.test.SemanticsMatcher
import com.google.samples.apps.nowinandroid.core.designsystem.component.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.component.LazyListSizeSemantics
import io.github.kakaocup.compose.node.builder.ViewBuilder
import io.github.kakaocup.compose.node.core.BaseNode
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemBuilder
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

object MainScreen : ComposeScreen<MainScreen>() {

    val items = createLazyList(
        viewBuilderAction = {
            hasTestTag("forYou:topicSelection")
        },
        itemTypeBuilder = {
            itemType(::TopicsItem)
        },
    )

    val newsList = createLazyList(
        viewBuilderAction = {
            hasTestTag("forYou:feed")
        },
        itemTypeBuilder = {
            itemType(::NewsItem)
        },
    )
}

fun BaseNode<*>.createLazyList(
    viewBuilderAction: ViewBuilder.() -> Unit,
    itemTypeBuilder: KLazyListItemBuilder.() -> Unit,
) = KLazyListNode(
    viewBuilderAction = viewBuilderAction,
    itemTypeBuilder = itemTypeBuilder,
    positionMatcher = {
        SemanticsMatcher.expectValue(LazyListItemPositionSemantics, it)
    },
    lengthSemanticsPropertyKey = LazyListSizeSemantics,
)