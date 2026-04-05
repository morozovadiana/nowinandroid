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

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.component.Tags
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode

class NewsItem(
    semanticNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider? = null,
) : KLazyListItemNode<NewsItem>(semanticNode, semanticsProvider) {

    val feedImage = child<KNode> {
        hasTestTag(Tags.NEWS_FEED_IMAGE)
    }
    val feedTitle = child<KNode> {
        hasTestTag(Tags.NEWS_FEED_TITLE)
    }
    val feedUncheckedBookmark = child<KNode> {
        hasTestTag(Tags.NEWS_FEED_UNCHECKED_BOOKMARK_ICON)
    }
    val feedCheckedBookmark = child<KNode> {
        hasTestTag(Tags.NEWS_FEED_CHECKED_BOOKMARK_ICON)
    }
    val feedDate = child<KNode> {
        hasTestTag(Tags.NEWS_FEED_METADATA_DATE)
    }

    val feedDescription = child<KNode> {
        hasTestTag(Tags.NEWS_FEED_SHORT_DESCRIPTION)
    }
}

