package com.palmdev.findamovie.data.mappers

interface Mapper<DataModel, DomainModel> {
    fun mapToDomain(dataModel: DataModel): DomainModel
    fun mapToData(domainModel: DomainModel): DataModel
}