package com.ostapr.narutocards.core.network.retrofit.api

import kotlinx.serialization.Serializable

@Serializable
internal data class NetworkResponse<T>(val value: T)