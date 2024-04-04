package com.example.musicplayer.Data

import androidx.annotation.DrawableRes
import com.example.musicplayer.R

data class TopPick(
    @DrawableRes val image:Int
)

val TopPicks= listOf(
    TopPick(R.drawable.top1),
    TopPick(R.drawable.top2),
    TopPick(R.drawable.top3),
    TopPick(R.drawable.top4),
    TopPick(R.drawable.top5),
    TopPick(R.drawable.top6),
    TopPick(R.drawable.top7)
)
data class Artist(
    @DrawableRes val image: Int,
    val name:String
)
val NewlyAdded= listOf(
    Artist(R.drawable.new1,"Yodha"),
    Artist(R.drawable.new2,"Malang Sajna"),
    Artist(R.drawable.new3,"TBMAUJ"),
    Artist(R.drawable.new4,"TJMM"),
    Artist(R.drawable.new5,"Fighter"),
    Artist(R.drawable.new6,"Dunki"),
    Artist(R.drawable.new7,"Animal"),
    Artist(R.drawable.new8,"Jawan"),
    Artist(R.drawable.new9,"Satyaprem Ki Katha")
)
val MadeForYou= listOf(
    Artist(R.drawable.made1,"Assamese Mix"),
    Artist(R.drawable.made2,"Udit Narayan"),
    Artist(R.drawable.made3,"Dooriyan"),
    Artist(R.drawable.made4,"Zubeen Garg Mix"),
    Artist(R.drawable.made5,"Hindi 2010-20 Mix"),
    Artist(R.drawable.made6,"Arijit Mix"),
    Artist(R.drawable.made7,"Hindi Mix")
)

val ArtistList = listOf(
    Artist(R.drawable.zubeen_garg,"Zubeen Garg"),
    Artist(R.drawable.papon,"Papon"),
    Artist(R.drawable.arijit,"Arijit Singh"),
    Artist(R.drawable.shreya,"Shreya Ghoshal"),
    Artist(R.drawable.arman,"Armaan Malik"),
    Artist(R.drawable.kumar,"Kumar Sanu"),
    Artist(R.drawable.sanu,"Sanu Nigam")
)
val RomanceList= listOf(
    Artist(R.drawable.r1,"Romance 2.0"),
    Artist(R.drawable.r2,"Love Anthem Punjabi"),
    Artist(R.drawable.r3,"Retro Romantic"),
    Artist(R.drawable.r4,"Slow Romantic Hindi"),
    Artist(R.drawable.r5,"Iconic Love Hits"),
    Artist(R.drawable.r6,"Sufi Love"),
)
val BrowserList= listOf(
    Artist(R.drawable.new1,"Yodha"),
    Artist(R.drawable.new2,"Malang Sajna"),
    Artist(R.drawable.new3,"TBMAUJ"),
    Artist(R.drawable.new4,"TJMM"),
    Artist(R.drawable.new5,"Fighter"),
    Artist(R.drawable.new6,"Dunki"),
    Artist(R.drawable.new7,"Animal"),
    Artist(R.drawable.new8,"Jawan"),
    Artist(R.drawable.new9,"Satyaprem Ki Katha"),
    Artist(R.drawable.r1,"Romance 2.0"),
    Artist(R.drawable.r2,"Love Anthem Punjabi"),
    Artist(R.drawable.r3,"Retro Romantic"),
    Artist(R.drawable.r4,"Slow Romantic Hindi"),
    Artist(R.drawable.r5,"Iconic Love Hits"),
    Artist(R.drawable.r6,"Sufi Love"),

)
