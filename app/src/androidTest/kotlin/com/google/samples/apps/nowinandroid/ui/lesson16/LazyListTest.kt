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

import android.graphics.pdf.models.ListItem
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import org.junit.Test

// Написать сценарий, в котором нужно кликнуть по элементу списка выбора топиков и проверить
// что отображается нулевой элемент появляющегося списка. Пример получения элемента списка по индексу (позиции)
// можно посмотреть в семплах Kakao compose.
abstract class ConfigureTest : TestCase(Kaspresso.Builder.withComposeSupport()) {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule(order = 2)
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)
}

@HiltAndroidTest
class ComposeTest : ConfigureTest() {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun checkZeroElementAppearedList() {
        run {
            step("отображение элементов списка") {
                MainScreen.items.childAt<TopicsItem>(0) {
                    text.assertIsDisplayed()
                    image.assertIsDisplayed()
                    plusIcon.assertIsDisplayed()
                }
                MainScreen.items.childAt<TopicsItem>(1) {
                    assertIsDisplayed()
                }
                MainScreen.items.childAt<TopicsItem>(2) {
                    assertIsDisplayed()
                }
            }
            step("клик по элементу списка выбора топиков") {
                MainScreen.items.childAt<TopicsItem>(2) {
                    plusIcon.performClick()
                    checkedIcon.assertIsDisplayed()
                }
            }
            step("проверить, что отображается нулевой элемент появляющегося списка") {
                MainScreen.newsList.childAt<NewsItem>(0) {
                    feedImage.assertIsDisplayed()
                    feedTitle.assertIsDisplayed()
                    feedUncheckedBookmark.assertIsDisplayed()
                    feedDate.assertIsDisplayed()
                    feedDescription.assertIsDisplayed()
                }
            }
        }
    }
}