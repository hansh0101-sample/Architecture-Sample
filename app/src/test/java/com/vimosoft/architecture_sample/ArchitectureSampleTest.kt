package com.vimosoft.architecture_sample

import com.vimosoft.architecture_sample.model.Game
import com.vimosoft.architecture_sample.model.GameResult
import com.vimosoft.architecture_sample.model.Pick
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ArchitectureSampleTest {
    private lateinit var game: Game

    @Test
    fun `내가_바위를_내고_상대가_바위를_낼_때`() {
        game = Game { it[0] }
        game.setMyPick(Pick.ROCK)
        assertEquals(GameResult.DRAW, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_보를_내고_상대가_바위를_낼_때`() {
        game = Game { it[0] }
        game.setMyPick(Pick.PAPER)
        assertEquals(GameResult.WIN, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_가위를_내고_상대가_바위를_낼_때`() {
        game = Game { it[0] }
        game.setMyPick(Pick.SCISSORS)
        assertEquals(GameResult.LOSE, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_바위를_내고_상대가_보를_낼_때`() {
        game = Game { it[1] }
        game.setMyPick(Pick.ROCK)
        assertEquals(GameResult.LOSE, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_보를_내고_상대가_보를_낼_때`() {
        game = Game { it[1] }
        game.setMyPick(Pick.PAPER)
        assertEquals(GameResult.DRAW, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_가위를_내고_상대가_보를_낼_때`() {
        game = Game { it[1] }
        game.setMyPick(Pick.SCISSORS)
        assertEquals(GameResult.WIN, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_바위를_내고_상대가_가위를_낼_때`() {
        game = Game { it[2] }
        game.setMyPick(Pick.ROCK)
        assertEquals(GameResult.WIN, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_보를_내고_상대가_가위를_낼_때`() {
        game = Game { it[2] }
        game.setMyPick(Pick.PAPER)
        assertEquals(GameResult.LOSE, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_가위를_내고_상대가_가위를_낼_때`() {
        game = Game { it[2] }
        game.setMyPick(Pick.SCISSORS)
        assertEquals(GameResult.DRAW, game.getPlayer1().gameResult)
    }

    @Test
    fun `내가_아무것도_내지_않았을_때`() {
        game = Game { it.toList().shuffled().first() }
        assertNull(null, game.getPlayer1().gameResult)
    }
}