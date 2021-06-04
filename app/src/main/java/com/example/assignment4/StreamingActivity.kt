package com.example.assignment4

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.activity_streaming.*

class StreamingActivity : AppCompatActivity() {

    private var videoURL:String = ""
    private var videoIndex: Int = 1
    private lateinit var player: SimpleExoPlayer
    private var playWhenReady: Boolean = true
    private var currentWindow: Int = 0
    private var playBackPosition: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streaming)

        videoIndex = intent.getIntExtra("video", 0)
        when(videoIndex){
            1-> videoURL = "https://www.hawkamah.org/videos/video-gallery/1475158487-28a59a9c962ff99b636bc10f2b497374-big_buck_bunny.mp4"
            2-> videoURL = "https://www.hawkamah.org/videos/video-gallery/1475154393-68312937d288981ae8b4b1bbc5d7d2ec-SampleVideo_1280x720_1mb.mp4"
            3-> videoURL = "https://www.hawkamah.org/videos/video-gallery/1475136548-e1968abdb8bce6106f9f583010c63c00-Hero%20Football%20TVC%202014.mp4"
            4-> videoURL = "https://resources.mestrelab.com/videos/Webinar-Mnova-Suite-Part-I-Dr-Irakusne-Lopez.mp4"
        }

    }

    private fun initVideo() {
        player = ExoPlayerFactory.newSimpleInstance(this)

        videoPlayer.player = player

        val uri: Uri = Uri.parse(videoURL)
        val dataSource: DataSource.Factory = DefaultDataSourceFactory(this,"exoplayer-codelab")
        val mediaSource: MediaSource = ProgressiveMediaSource.Factory(dataSource).createMediaSource(uri)
        player.playWhenReady = playWhenReady
        player.seekTo(currentWindow, playBackPosition)
        player.prepare(mediaSource,false,false)
    }

    private fun releaseVideo() {
        if (player.isPlaying){
            playWhenReady = player.playWhenReady
            playBackPosition = player.currentPosition
            currentWindow = player.currentWindowIndex
            player.release()
        }
    }

    override fun onStart() {
        super.onStart()
        initVideo()
    }

    override fun onResume() {
        super.onResume()
        if(player.isPlaying){
            initVideo()
        }
    }

    override fun onStop() {
        super.onStop()
        releaseVideo()
    }

    override fun onPause() {
        super.onPause()
        releaseVideo()
    }

}