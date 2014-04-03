package com.github.j5ik2o.spetstore.domain.model.purchase

import com.github.j5ik2o.spetstore.domain.infrastructure.support.EntityIOContext
import com.github.j5ik2o.spetstore.domain.lifecycle.item.ItemRepository
import com.github.j5ik2o.spetstore.domain.model.basic.StatusType
import com.github.j5ik2o.spetstore.domain.model.item.ItemId
import scala.util.Try

/**
 * 注文する商品を表す値オブジェクト。
 *
 * @param itemId [[com.github.j5ik2o.spetstore.domain.model.item.Item]]のI
 * @param quantity 数量
 */
case class OrderItem(id: OrderItemId, no: Long, status: StatusType.Value, itemId: ItemId, quantity: Int) {

  /**
   * 小計。
   */
  def subTotalPrice(implicit ir: ItemRepository, ctx: EntityIOContext): Try[BigDecimal] =
    ir.resolveEntity(itemId).map(_.price * quantity)

}

/**
 * コンパニオンオブジェクト。
 */
object OrderItem {

  /**
   * [[com.github.j5ik2o.spetstore.domain.model.purchase.CartItem]]から
   * [[com.github.j5ik2o.spetstore.domain.model.purchase.OrderItem]]を
   * 生成する。
   *
   * @param cartItem [[com.github.j5ik2o.spetstore.domain.model.purchase.CartItem]]
   * @return [[com.github.j5ik2o.spetstore.domain.model.purchase.OrderItem]]
   */
  def fromCartItem(orderItemId: OrderItemId, cartItem: CartItem): OrderItem =
    OrderItem(orderItemId, cartItem.no, cartItem.status, cartItem.itemId, cartItem.quantity)


}
