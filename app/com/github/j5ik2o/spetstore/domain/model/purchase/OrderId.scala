package com.github.j5ik2o.spetstore.domain.model.purchase

import com.github.j5ik2o.spetstore.domain.infrastructure.support.Identifier
import com.github.j5ik2o.spetstore.domain.lifecycle.IdentifierService

/**
 * [[com.github.j5ik2o.spetstore.domain.model.purchase.Order]]のための識別子。
 *
 * @param value 識別子の値
 */
case class OrderId(value: Long)
  extends Identifier[Long]
