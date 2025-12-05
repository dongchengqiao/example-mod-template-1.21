package com.dongchengqiao.example.block.custom;

import com.dongchengqiao.example.block.entity.BoxBlockEntity;
import com.dongchengqiao.example.block.entity.ModBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BoxBlock extends BlockWithEntity {
    public static final MapCodec<BoxBlock> CODEC = BoxBlock.createCodec(BoxBlock::new);

    public BoxBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BoxBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.Box, BoxBlockEntity::tick);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof NamedScreenHandlerFactory) {
                player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        // 检查方块是否被真正替换（而不仅仅是状态更新）
        if (state.getBlock() != newState.getBlock()) {
            // 获取方块实体
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BoxBlockEntity) { // 请替换为你的BoxBlockEntity类
                // 散射方块实体内部物品 [citation:5]
                ItemScatterer.spawn(world, pos, (BoxBlockEntity) blockEntity);
                // 更新比较器，确保红石元件能正确响应 [citation:5]
                world.updateComparators(pos, this);
            }
        }
        // 调用父类方法处理其他逻辑
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    // 可选但推荐：实现比较器输出，使箱子能被红石比较器读取 [citation:5]
    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        // 计算基于容器满载程度的比较器信号
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }
}
