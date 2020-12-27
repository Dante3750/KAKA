package com.globals.netconnect.kaka.sprites;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.globals.netconnect.kaka.Game;
import com.globals.netconnect.kaka.GameView;


public class Accessory extends Sprite {
    
    public Accessory(GameView view, Game game) {
        super(view, game);
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setBitmap(Bitmap bitmap){
        this.bitmap = bitmap;
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
    }

    @Override
    public void draw(Canvas canvas) {
        if(this.bitmap != null){
            super.draw(canvas);
        }
    }
}
