package com.selincengiz.composepractice.presentation.onboarding

import androidx.annotation.DrawableRes
import com.selincengiz.composepractice.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,









)

val pages =
    listOf(
        Page(
            title = "Dünya Parmaklarınızın Ucunda",
            description = "En güncel haberler, ayrıntılı analizler ve özel içeriklerle dünyanın dört bir yanından en önemli gelişmeleri takip edin.",
            image = R.drawable.onboarding1,
        ),
        Page(
            title = "Dünya Parmaklarınızın Ucunda",
            description = "En güncel haberler, ayrıntılı analizler ve özel içeriklerle dünyanın dört bir yanından en önemli gelişmeleri takip edin.",
            image = R.drawable.onboarding1,
        ),
        Page(
            title = "Dünya Parmaklarınızın Ucunda",
            description = "En güncel haberler, ayrıntılı analizler ve özel içeriklerle dünyanın dört bir yanından en önemli gelişmeleri takip edin.",
            image = R.drawable.onboarding1,
        ),
        Page(
            title = "Gelişmiş Arama ile Kolay Erişim",
            description = "Arama özelliğimiz sayesinde istediğiniz haber başlıklarına ve detaylara anında ulaşın.",
            image = R.drawable.onboarding2,
        ),
        Page(
            title = "Haberleri Kaydedin, Daha Sonra Okuyun",
            description = "Bookmark özelliğimizle ilginizi çeken haberleri kaydedin. Dilediğiniz zaman geri dönüp okuyabileceğiniz bir haber arşivi oluşturun.",
            image = R.drawable.onboarding3,
        ),
    )
