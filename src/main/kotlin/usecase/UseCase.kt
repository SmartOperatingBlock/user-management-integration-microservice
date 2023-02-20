/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package usecase

/**
 * The interface of a domain use case.
 * @param E the return type of the use case.
 */
interface UseCase<out E> {

    /** Execute the use case. */
    fun execute(): E
}
