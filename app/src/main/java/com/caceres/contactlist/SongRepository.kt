package com.caceres.contactlist

import com.caceres.contactlist.model.Song

class SongRepository ( val songs:MutableList<Song> = ArrayList()){

    init {
        setDataSongs()
    }

    private fun setDataSongs(): List<Song> {
        songs.add(Song(100, "Arena Hash - Y es que sucede así", "Rock", "img_arenahash"))
        songs.add(Song(200, "Nirvana - About a Girl", "Rock", "img_nirvana"))
        songs.add(Song(300, "Inner Circle - Bad Boys ", "Reggae", "img_innercircle"))
        songs.add(Song(400, "Shakira - Hips Don't Lie", "Dance Pop", "img_shakira"))
        songs.add(Song(500, "Neovaii - Crash", "Electronica", "img_neovaii"))
        songs.add(Song(600, "Black Sabbath - Paranoid", "Heavy Metal", "img_blacksabbath"))
        songs.add(Song(700, "The Beatles - Help!", "Rock", "img_thebeatles"))
        songs.add(Song(800, "Jack Stauber - Buttercup", "Pop", "img_jackstauber"))
        songs.add(Song(900, "Eminem - Rap God", "Rap", "img_eminem_rapgod"))
        songs.add(Song(1000, "Eminem - Mockingbird", "Rap", "img_eminem_mockingbird"))
        return songs

    }

}

