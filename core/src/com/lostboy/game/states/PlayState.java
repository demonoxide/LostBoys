package com.lostboy.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.lostboy.game.Lost_Boy;
import com.lostboy.game.sprites.LostBoy;
import com.lostboy.game.sprites.Tree;

import java.util.ArrayList;


/**
 * Created by Andy on 5/15/2016.
 */
public class PlayState extends State {
    private LostBoy bird;
    private Texture background;
    private Tree tree;
    private Array<Tree> trees;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new LostBoy(50,300);
        cam.setToOrtho(false, Lost_Boy.WIDTH / 2, Lost_Boy.HEIGHT / 2);
        background = new Texture("grass.png");
        trees = new Array<Tree>();

    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {

            bird.jump();
//            tree = new Tree(Gdx.input.getX(), Gdx.input.getY());
        }
//        if(Gdx.input.justTouched()){
//            tree = new Tree(Gdx.input.getX(), Gdx.input.getY());
//            trees.add(tree);
//        }
        if(Gdx.input.justTouched()){
            int x = Gdx.input.getX()/2;
            int y = (Lost_Boy.HEIGHT - Gdx.input.getY())/2;
            tree = new Tree(x, y);
            trees.add(tree);
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        for(int i = 0; i < trees.size; i++){
            sb.draw(trees.get(i).getTree(), trees.get(i).getPosition().x, trees.get(i).getPosition().y);
        }
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
