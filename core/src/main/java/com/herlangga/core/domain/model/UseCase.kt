package com.herlangga.core.domain.model

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
interface UseCase<ParamType, ReturnType> {

 operator fun invoke(param: ParamType): ReturnType
}

object NoParams