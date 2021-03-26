package com.theaemogie.learninggame.components;

import com.theaemogie.learninggame.renderer.Texture;
import org.joml.Vector2f;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:theaemogie@gmail.com"> Aemogie. </a>
 */
public class SpriteSheet {

    private Texture texture;
    private List<Sprite> sprites;

    public SpriteSheet(Texture texture, int spriteWidth, int spriteHeight, int numOfSprites, int spacing) {
        this.sprites = new ArrayList<>();
        this.texture = texture;

        int currentX = 0;
        int currentY = texture.getHeight() - spriteHeight;

        for (int i = 0; i < numOfSprites; i++) {
            float topY = (currentY + spriteHeight) / (float)texture.getHeight();
            float rightX = (currentX + spriteWidth) / (float)texture.getWidth();
            float leftX = currentX / (float)texture.getWidth();
            float bottomY = currentY / (float)texture.getHeight();

            Vector2f[] textureCoords = {
                    new Vector2f(rightX, topY),
                    new Vector2f(rightX, bottomY),
                    new Vector2f(leftX, bottomY),
                    new Vector2f(leftX, topY)
            };

            Sprite sprite = new Sprite(this.texture, textureCoords);
            this.sprites.add(sprite);

            currentX += spriteWidth + spacing;
            if (currentX >= texture.getWidth()) {
                currentX = 0;
                currentY -= spriteHeight + spacing;
            }
        }
    }

//    public SpriteSheet(Texture texture, int spriteWidth, int spriteHeight, int numOfSprites, int spacing) {
//        new SpriteSheet(texture, spriteWidth, spriteHeight, numOfSprites, spacing, spacing);
//    }
//
//    public SpriteSheet(Texture texture, int spriteWidth, int spriteHeight, int numOfSprites) {
//        new SpriteSheet(texture, spriteWidth, spriteHeight, numOfSprites, 0);
//    }

    public Sprite getSprite(int index) {
        System.out.println("Getting sprite: " + index);
        return this.sprites.get(index);
    }
}
