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

package com.google.samples.apps.nowinandroid.ui.lesson15.homework

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

// Добавить теги на элементы топ бара (поиск, заголовок, шестерёнка)

//Добавить теги на заголовок и подзаголовок над списком и на кнопку под списком.

//Найти теги кнопок в нижнем навбаре (да, они там есть!) - описывать не нужно.
// kotlin/com/google/samples/apps/nowinandroid/ui/NiaApp.kt

//Нажать кнопку поиска и добавить теги на элементы верхнего тулбара.

//Описать элементы на которые добавили теги в соответствующих пейджобжектах

//Написать сценарии, которые проверяют все элементы, переходят на экран поиска и проверяют элементы там.

abstract class ConfigureTest : TestCase(Kaspresso.Builder.withComposeSupport()) {
    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @get:Rule(order = 2)
    val kakaoRule = KakaoComposeTestRule(composeTestRule, true)
}

@HiltAndroidTest
class HwComposeTest : ConfigureTest() {

    @Test
    fun checkToolbarItemsIsDisplayed() {
        run {
            OnboardingScreen {
                searchButton.assertIsDisplayed()
                toolbarTitle.assertIsDisplayed()
                settingsButton.assertIsDisplayed()
            }
        }
    }

    @Test
    fun checkTitleIsDisplayed() {
        run {
            OnboardingScreen.title.assertIsDisplayed()
        }
    }

    @Test
    fun checkSubtitleIsDisplayed() {
        run {
            OnboardingScreen.subtitle.assertIsDisplayed()
        }
    }

    @Test
    fun checkDoneButtonIsDisplayed() {
        run {
            OnboardingScreen.doneButton.assertIsDisplayed()
        }
    }

    @Test
    fun checkSearchScreen() {
        run {
            OnboardingScreen {
                searchButton.performClick()
            }
            SearchScreen {
                backButton.assertIsDisplayed()
                recentSearches.assertIsDisplayed()
                textField.assertIsDisplayed()
            }
        }
    }
}