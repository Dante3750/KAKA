/**
 * A yummy toast
 * 
 * @author Lars Harmsen
 * Copyright (c) <2014> <Lars Harmsen - Quchen>
 */

package com.globals.netconnect.kaka.sprites;

import android.graphics.Bitmap;

import com.globals.netconnect.kaka.Game;
import com.globals.netconnect.kaka.GameView;
import com.globals.netconnect.kaka.R;
import com.globals.netconnect.kaka.Util;


public class Toast extends PowerUp {
    
    /**
     * Static bitmap to reduce memory usage.
     */
    public static Bitmap globalBitmap;
    
    public static final int POINTS_TO_TOAST = 42;

    public Toast(GameView view, Game game) {
        super(view, game);
        if(globalBitmap == null){
            globalBitmap = Util.getScaledBitmapAlpha8(game, R.drawable.toast);
        }
        this.bitmap = globalBitmap;
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
    }

    /**
     * When eaten the player will turn into nyan cat.
     */
    @Override
    public void onCollision() {
        super.onCollision();
        view.changeToNyanCat();
    }
    
    
}
