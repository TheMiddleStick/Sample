package com.ztd;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Zombie Kimchi;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("bg_snow.png"));
		Kimchi = new Zombie(300, 300);
	}

	@Override
	public void render () {
		update();

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		Kimchi.draw(batch);
		batch.end();
	}

	public void update (){
		Kimchi.update();

	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
