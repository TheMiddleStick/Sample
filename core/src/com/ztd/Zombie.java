package com.ztd;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import org.w3c.dom.Text;

public class Zombie {
    int x, y, w, h;
    Texture text;
    boolean active = true;

    //Animation
    Animation anim;
    TextureRegion[] frames;
    TextureRegion frame;
    float frame_time = 0.2f;
    int cols = 4, rows = 1;

    Zombie (int x, int y){
        this.x = x;
        this.y = y;
        text = new Texture(Gdx.files.internal("Zombies.png"));
        w = text.getWidth() /cols;
        h = text.getHeight() /rows;
        init_animations();
    }

        void  init_animations() {
        // splits texture into individual cells
        TextureRegion[][] sheet = TextureRegion.split(text, w, h);

        //init number of frames to total frames created (vertical + horizontal)
        frames = new TextureRegion[rows * cols];

        //loop thru sheet and fill frames array in order
        int index = 0;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                frames[index++] = sheet[r][c];

            anim = new Animation(frame_time, frames);
    }

    void update(){
        x -= 3;
        active = !(x < -w);
    }

    void draw (SpriteBatch b){
        frame_time += Gdx.graphics.getDeltaTime();
        frame = (TextureRegion)anim.getKeyFrame(frame_time,true);
        b.draw(frame, x, y, w, h);
    }
}
