/**
 * A Coin
 * 
 * @author Lars Harmsen
 * Copyright (c) <2014> <Lars Harmsen - Quchen>
 */

package com.globals.netconnect.kaka.sprites;

import android.graphics.Bitmap;

import com.globals.netconnect.kaka.Game;
import com.globals.netconnect.kaka.GameView;
import com.globals.netconnect.kaka.MainActivity;
import com.globals.netconnect.kaka.R;
import com.globals.netconnect.kaka.Util;


public class Coin extends PowerUp {
    /**
     * Static bitmap to reduce memory usage.
     */
    public static Bitmap globalBitmap;
    private static int sound = -1;

    public Coin(GameView view, Game game) {
        super(view, game);
        if(globalBitmap == null){
            globalBitmap = Util.getScaledBitmapAlpha8(game, R.drawable.coin);
        }
        this.bitmap = globalBitmap;
        this.width = this.bitmap.getWidth()/(colNr = 12);
        this.height = this.bitmap.getHeight();
        this.frameTime = 1;
        if(sound == -1){
            sound = Game.soundPool.load(game, R.raw.coin, 1);
        }
    }

    /**
     * When eaten the player will turn into nyan cat.
     */
    @Override
    public void onCollision() {
        super.onCollision();
        playSound();
        game.increaseCoin();
    }
    
    private void playSound(){
        Game.soundPool.play(sound, MainActivity.volume, MainActivity.volume, 0, 0, 1);
    }
    
    @Override
    public void move() {
        changeToNextFrame();
        super.move();
    }
}
