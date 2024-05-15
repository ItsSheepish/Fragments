package its.sheepish.fragments.blocks.entity.renderer;
import its.sheepish.fragments.blocks.entity.SoulInfuserBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class SoulInfuserBlockEntityRenderer implements BlockEntityRenderer<SoulInfuserBlockEntity> {
    public SoulInfuserBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }

    @Override
    public void render(SoulInfuserBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getRenderStack();

        matrices.push();
        matrices.translate(0.35f, 0.65f, 0.75f);
        matrices.scale(0.5f, 0.5f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-30));

        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);

        renderSoul1(entity, matrices, vertexConsumers, getLightLevel(entity.getWorld(),
                entity.getPos()), overlay);
        renderSoul2(entity, matrices, vertexConsumers, getLightLevel(entity.getWorld(),
                entity.getPos()), overlay);
        renderSoul3(entity, matrices, vertexConsumers, getLightLevel(entity.getWorld(),
                entity.getPos()), overlay);
        renderSoul4(entity, matrices, vertexConsumers, getLightLevel(entity.getWorld(),
                entity.getPos()), overlay);

        matrices.pop();
    }

    private void renderSoul1(SoulInfuserBlockEntity entity, MatrixStack matrices,
                                   VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack soulStack = entity.getRenderStack1(); // Example light source item

        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(30));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
        matrices.translate(0.85f, 0.0f, -1f); // Position the light source above the block
        matrices.scale(0.75f, 0.75f, 0.75f); // Scale if necessary
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45));

        itemRenderer.renderItem(soulStack, ModelTransformationMode.GUI, light, overlay, matrices, vertexConsumers, entity.getWorld(), 1);

        matrices.pop();
    }
    private void renderSoul2(SoulInfuserBlockEntity entity, MatrixStack matrices,
                             VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack soulStack1 = entity.getRenderStack2(); // Example light source item

        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(30));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
        matrices.translate(0.85f, 0.075f, -1f); // Position the light source above the block
        matrices.scale(0.75f, 0.75f, 0.75f); // Scale if necessary
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45));
        matrices.translate(0.05,-0.05,0); // Position the light source above the block
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-20));

        itemRenderer.renderItem(soulStack1, ModelTransformationMode.GUI, light, overlay, matrices, vertexConsumers, entity.getWorld(), 1);

        matrices.pop();
    }
    private void renderSoul3(SoulInfuserBlockEntity entity, MatrixStack matrices,
                             VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack soulStack1 = entity.getRenderStack3(); // Example light source item

        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(30));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
        matrices.translate(0.85f, 0.15f, -1f); // Position the light source above the block
        matrices.scale(0.75f, 0.75f, 0.75f); // Scale if necessary
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45));
        matrices.translate(-0.05,0.075,0); // Position the light source above the block
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(40));

        itemRenderer.renderItem(soulStack1, ModelTransformationMode.GUI, light, overlay, matrices, vertexConsumers, entity.getWorld(), 1);

        matrices.pop();
    }
    private void renderSoul4(SoulInfuserBlockEntity entity, MatrixStack matrices,
                             VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack soulStack1 = entity.getRenderStack4(); // Example light source item

        matrices.push();
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(30));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));
        matrices.translate(0.85f, 0.225f, -1f); // Position the light source above the block
        matrices.scale(0.75f, 0.75f, 0.75f); // Scale if necessary
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(45));
        matrices.translate(-0.075,-0.075,0); // Position the light source above the block
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-60));

        itemRenderer.renderItem(soulStack1, ModelTransformationMode.GUI, light, overlay, matrices, vertexConsumers, entity.getWorld(), 1);

        matrices.pop();
    }
}
