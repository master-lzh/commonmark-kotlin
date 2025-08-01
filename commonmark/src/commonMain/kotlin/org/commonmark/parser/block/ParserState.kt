package org.commonmark.parser.block

import org.commonmark.parser.SourceLine

/**
 * State of the parser that is used in block parsers.
 *
 * *This interface is not intended to be implemented by clients.*
 */
interface ParserState {
    /**
     * @return the current source line being parsed (full line)
     */
    val line: SourceLine

    /**
     * @return the current index within the line (0-based)
     */
    val index: Int

    /**
     * @return the index of the next non-space character starting from [.getIndex] (may be the same) (0-based)
     */
    val nextNonSpaceIndex: Int

    /**
     * The column is the position within the line after tab characters have been processed as 4-space tab stops.
     * If the line doesn't contain any tabs, it's the same as the [.getIndex]. If the line starts with a tab,
     * followed by text, then the column for the first character of the text is 4 (the index is 1).
     *
     * @return the current column within the line (0-based)
     */
    val column: Int

    /**
     * @return the indentation in columns (either by spaces or tab stop of 4), starting from [.getColumn]
     */
    val indent: Int

    /**
     * @return true if the current line is blank starting from the index
     */
    val isBlank: Boolean

    /**
     * @return the deepest open block parser
     */
    val activeBlockParser: BlockParser
}
