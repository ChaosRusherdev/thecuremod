package de.crdev.thecure.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

public class SculcAcidParticle extends SpriteBillboardParticle {
    private float _scale = 0.25f;
    private int _maxAge = 2;
    public SculcAcidParticle(ClientWorld world, double xCoord, double yCoord, double zCoord,
                                 SpriteProvider spriteSet, double xd, double yd, double zd) {
        super(world, xCoord, yCoord, zCoord, xd, yd, zd);

        this.velocityMultiplier = 0.2f;
        this.velocityX = xd;
        this.velocityY = yd;
        this.velocityZ = zd;

        this.scale += _scale;
        this.maxAge = _maxAge;
        this.setSpriteForAge(spriteSet);
    }
    public void setScale(float _scale) {
        this._scale = _scale;
    }
    public float getScale() {
        return this._scale;
    }
    public void setMaxAge(int _maxAge) {
        this._maxAge = _maxAge;
    }
    public int getMaxAge() {
        return this._maxAge;
    }


    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider sprites;

        public Factory(SpriteProvider spriteProvider) {
            this.sprites = spriteProvider;
        }
        public Particle createParticle(DefaultParticleType particleType, ClientWorld clientWorld,
                                       double x, double y, double z, double xd, double yd, double zd) {
            return new SculcAcidParticle(clientWorld, x, y, z, this.sprites, xd, yd, zd);
        }
    }
}
