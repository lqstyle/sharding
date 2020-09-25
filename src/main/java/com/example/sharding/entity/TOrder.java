package com.example.sharding.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lucas
 * @since 2020-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TOrder extends Model<TOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号（主键）
     */
    private Long orderId;

    /**
     * 订单名称
     */
    private String orderName;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 用户id
     */
    private Long userId;

    private Long id;


    @Override
    protected Serializable pkVal() {
        return this.orderId;
    }

}
