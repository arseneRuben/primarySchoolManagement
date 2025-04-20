import express from 'express'
import { createUser, deleteUser, getUser, getUsers, updateUser, toggle } from '../dao/sql/user.js'
const router = express.Router()


/* READ */
router.get('/', getUsers)
//router.get('/:id', getUserById)

/* CREATE */
router.post('/signup', createUser)
router.post('/signin', getUser)
/* UPDATE */
router.put('/:id', updateUser)
router.patch('/:id', toggle)

/* DELETE */
router.delete('/:id', deleteUser)

export default router