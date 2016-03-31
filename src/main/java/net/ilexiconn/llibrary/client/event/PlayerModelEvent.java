package net.ilexiconn.llibrary.client.event;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PlayerModelEvent extends Event {
    protected ModelPlayer model;

    public PlayerModelEvent(ModelPlayer model) {
        this.model = model;
    }

    public static class Assign extends PlayerModelEvent {
        protected RenderPlayer renderPlayer;

        public Assign(RenderPlayer renderPlayer, ModelPlayer model) {
            super(model);
            this.renderPlayer = renderPlayer;
        }

        public RenderPlayer getRenderPlayer() {
            return this.renderPlayer;
        }

        public void setModel(ModelPlayer model) {
            this.model = model;
        }
    }

    public static class Construct extends PlayerModelEvent {
        public Construct(ModelPlayer model) {
            super(model);
        }
    }

    public static class SetRotationAngles extends Render {
        public SetRotationAngles(ModelPlayer model, EntityPlayer player, float limbSwing, float limbSwingAmount, float rotation, float rotationYaw, float rotationPitch, float scale) {
            super(model, player, limbSwing, limbSwingAmount, rotation, rotationYaw, rotationPitch, scale);
        }
    }

    public static class Render extends PlayerModelEvent {
        public final EntityPlayer entityPlayer;
        public final float limbSwing;
        public final float limbSwingAmount;
        public final float rotation;
        public final float rotationYaw;
        public final float rotationPitch;
        public final float scale;

        public Render(ModelPlayer model, EntityPlayer player, float limbSwing, float limbSwingAmount, float rotation, float rotationYaw, float rotationPitch, float scale) {
            super(model);
            this.entityPlayer = player;
            this.limbSwing = limbSwing;
            this.limbSwingAmount = limbSwingAmount;
            this.rotation = rotation;
            this.rotationYaw = rotationYaw;
            this.rotationPitch = rotationPitch;
            this.scale = scale;
        }
    }

    public ModelPlayer getModel() {
        return this.model;
    }
}