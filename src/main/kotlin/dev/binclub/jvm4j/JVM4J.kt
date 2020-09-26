@file:Suppress("FunctionName", "unused")

package dev.binclub.jvm4j

/**
 * @author cookiedragon234 26/Sep/2020
 */
object JVM4J {
	private val loader = Loader // initialize this to load native library
	
	@JvmStatic
	fun getVM(): JavaVM {
		val p = getVM0()
		if (p == 0L) {
			throw NullPointerException("JavaVM was null")
		}
		return JavaVM(p)
	}
	
	@JvmStatic
	fun getJvmti(vm: JavaVM): Jvmti {
		val p = getJvmti0(vm.javaVM_P)
		if (p == 0L) {
			throw NullPointerException("Jvmti not supported")
		}
		return Jvmti(p)
	}
	
	@JvmStatic
	fun getJmm(): Jmm {
		val p = getJmm0()
		if (p == 0L) {
			throw NullPointerException("Jmm not supported")
		}
		return Jmm(p)
	}
	
	private external fun getVM0(): Long
	private external fun getJvmti0(vm: Long): Long
	private external fun getJmm0(): Long
	
	external fun getInterfaceVersion(): Int
	external fun iHashCode(obj: Any?): Int
	external fun monitorWait(obj: Any?, ms: Long)
	external fun monitorNotify(obj: Any?)
	external fun monitorNotifyAll(obj: Any?)
	external fun clone(obj: Any?): Any?
	external fun internString(str: String?): String?
	@JvmOverloads
	external fun currentTimeMillis(ignored: Class<*>? = null): Long
	@JvmOverloads
	external fun nanoTime(ignored: Class<*>? = null): Long
	@JvmOverloads
	external fun arrayCopy(ignored: Class<*>? = null, src: Any?, src_pos: Int, dst: Any?, dst_pos: Int, length: Int)
	external fun initProperties(p: Any?): Any?
	external fun onExit(op: Runnable) // TODO: Not yet implemented
	external fun exit(code: Int)
	external fun halt(code: Int)
	external fun gc()
	external fun maxObjectInspectionAge(): Long
	external fun traceInstructions(on: Boolean)
	external fun traceMethodCalls(on: Boolean)
	external fun totalMemory(): Long
	external fun freeMemory(): Long
	external fun maxMemory(): Long
	external fun activeProcessorCount(): Int
	external fun loadLibrary(name: String): Long
	external fun unloadLibrary(handle: Long)
	external fun findLibraryEntry(handle: Long, name: String): Long
	external fun isSupportedJNIVersion(version: Int): Boolean
	external fun isNaN(d: Double): Boolean
	external fun fillInStackTrace(throwable: Throwable)
	external fun getStackTraceDepth(throwable: Throwable): Int
	external fun getStackTraceElement(throwable: Throwable, index: Int): Any?
	external fun initializeCompiler(compCls: Class<*>?)
	external fun isSilentCompiler(compCls: Class<*>?): Boolean
	external fun compileClass(compCls: Class<*>?, cls: Class<*>): Boolean
	external fun compileClasses(compCls: Class<*>?, name: String): Boolean
	external fun compilerCommand(compCls: Class<*>?, arg: Any?): Any
	external fun startThread(thread: Thread)
	external fun stopThread(thread: Thread, exception: Any?)
	external fun isThreadAlive(thread: Thread): Boolean
	external fun suspendThread(thread: Thread)
	external fun resumeThread(thread: Thread)
	external fun setThreadPriority(thread: Thread, priority: Int)
	external fun yield(threadClass: Class<*>?)
	external fun sleep(threadClass: Class<*>?, ms: Long)
	external fun currentThread(threadClass: Class<*>?): Thread?
	external fun countStackFrames(thread: Thread): Int
	external fun interrupt(thread: Thread)
	external fun isInterrupted(thread: Thread, clearInterrupted: Boolean): Boolean
	external fun holdsLock(threadClass: Class<*>?, obj: Any): Boolean
	@JvmOverloads
	external fun dumpAllStacks(unused: Class<*>? = null)
	@JvmOverloads
	external fun getAllThreads(dummy: Class<*>? = null): Array<Thread>
	external fun setNativeThreadName(thread: Any, name: String)
	external fun dumpThreads(threadClass: Class<*>?, threads: Array<Thread>): Array<Thread>
	external fun currentLoadedClass(): Class<*>
	external fun currentClassLoader(): ClassLoader?
	external fun getClassContext(): Array<Any?>
	external fun classDepth(name: String): Int
	external fun classLoaderDepth(): Int
	external fun getSystemPackages(): Array<Any?>
	external fun allocateNewObject(obj: Any?, currClass: Class<*>, initClass: Class<*>): Any
	external fun allocateNewArray(obj: Any?, currClass: Class<*>, length: Int): Any
	external fun latestUserDefinedLoader(): ClassLoader?
	external fun loadClass0(obj: Any?, currClass: Class<*>, currClassName: String): Class<*>
	external fun getArrayLength(arr: Any): Int
	external fun getArrayElement(arr: Any, index: Int): Any
	// TODO: carry on
}
