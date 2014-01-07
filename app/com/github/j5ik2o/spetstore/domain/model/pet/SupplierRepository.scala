package com.github.j5ik2o.spetstore.domain.model.pet

import com.github.j5ik2o.spetstore.domain.infrastructure.support.Repository

/**
 * [[com.github.j5ik2o.spetstore.domain.model.pet.Supplier]]のためのリポジトリ責務。
 */
trait SupplierRepository extends Repository[SupplierId, Supplier] {

  type This = SupplierRepository

}

/**
 * コンパニオンオブジェクト。
 */
object SupplierRepository {

  /**
   * メモリ用リポジトリを生成する。
   *
   * @param entities エンティティの集合
   * @return [[com.github.j5ik2o.spetstore.domain.model.pet.CategoryRepository]]
   */
  def ofMemory(entities: Map[SupplierId, Supplier] = Map.empty): SupplierRepository =
    new SupplierRepositoryOnMemory(entities)

  /**
   * JDBC用リポジトリを生成する。
   *
   * @return [[com.github.j5ik2o.spetstore.domain.model.pet.CategoryRepository]]
   */
  def ofJDBC: SupplierRepository = new SupplierRepositoryOnJDBC

}