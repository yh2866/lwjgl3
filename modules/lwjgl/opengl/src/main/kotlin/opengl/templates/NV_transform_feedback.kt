/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package opengl.templates

import org.lwjgl.generator.*
import opengl.*

val NV_transform_feedback = "NVTransformFeedback".nativeClassGL("NV_transform_feedback", postfix = NV) {
    documentation =
        """
        Native bindings to the $registryLink extension.

        This extension provides a new mode to the GL, called transform feedback, which records vertex attributes of the primitives processed by the GL. The
        selected attributes are written into buffer objects, and can be written with each attribute in a separate buffer object or with all attributes
        interleaved into a single buffer object. If a geometry program or shader is active, the primitives recorded are those emitted by the geometry program.
        Otherwise, transform feedback captures primitives whose vertex are transformed by a vertex program or shader, or by fixed-function vertex processing.
        In either case, the primitives captured are those generated prior to clipping. Transform feedback mode is capable of capturing transformed vertex data
        generated by fixed-function vertex processing, outputs from assembly vertex or geometry programs, or varying variables emitted from GLSL vertex or
        geometry shaders.

        The vertex data recorded in transform feedback mode is stored into buffer objects as an array of vertex attributes. The regular representation and the
        use of buffer objects allows the recorded data to be processed directly by the GL without requiring CPU intervention to copy data. In particular,
        transform feedback data can be used for vertex arrays (via vertex buffer objects), as the source for pixel data (via pixel buffer objects), as program
        constant data (via the NV_parameter_buffer_object or EXT_bindable_uniform extension), or via any other extension that makes use of buffer objects.

        This extension introduces new query object support to allow transform feedback mode to operate asynchronously. Query objects allow applications to
        determine when transform feedback results are complete, as well as the number of primitives processed and written back to buffer objects while in
        transform feedback mode. This extension also provides a new rasterizer discard enable, which allows applications to use transform feedback to capture
        vertex attributes without rendering anything.

        Requires ${GL15.core}.
        """

    IntConstant(
        """
        Accepted by the {@code target} parameters of BindBuffer, BufferData, BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData, GetBufferPointerv,
        BindBufferRangeNV, BindBufferOffsetNV and BindBufferBaseNV.
        """,

        "TRANSFORM_FEEDBACK_BUFFER_NV"..0x8C8E
    )

    IntConstant(
        "Accepted by the {@code param} parameter of GetIntegerIndexedvEXT and GetBooleanIndexedvEXT.",

        "TRANSFORM_FEEDBACK_BUFFER_START_NV"..0x8C84,
        "TRANSFORM_FEEDBACK_BUFFER_SIZE_NV"..0x8C85,
        "TRANSFORM_FEEDBACK_RECORD_NV"..0x8C86
    )

    IntConstant(
        """
        Accepted by the {@code param} parameter of GetIntegerIndexedvEXT and GetBooleanIndexedvEXT, and by the {@code pname} parameter of GetBooleanv,
        GetDoublev, GetIntegerv, and GetFloatv.
        """,

        "TRANSFORM_FEEDBACK_BUFFER_BINDING_NV"..0x8C8F
    )

    IntConstant(
        "Accepted by the {@code bufferMode} parameter of TransformFeedbackAttribsNV and TransformFeedbackVaryingsNV.",

        "INTERLEAVED_ATTRIBS_NV"..0x8C8C,
        "SEPARATE_ATTRIBS_NV"..0x8C8D
    )

    IntConstant(
        "Accepted by the {@code target} parameter of BeginQuery, EndQuery, and GetQueryiv.",

        "PRIMITIVES_GENERATED_NV"..0x8C87,
        "TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN_NV"..0x8C88
    )

    IntConstant(
        """
        Accepted by the {@code cap} parameter of Enable, Disable, and IsEnabled, and by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and
        GetDoublev.
        """,

        "RASTERIZER_DISCARD_NV"..0x8C89
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of GetBooleanv, GetDoublev, GetIntegerv, and GetFloatv.",

        "MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS_NV"..0x8C8A,
        "MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS_NV"..0x8C8B,
        "MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS_NV"..0x8C80,
        "TRANSFORM_FEEDBACK_ATTRIBS_NV"..0x8C7E
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of GetProgramiv.",

        "ACTIVE_VARYINGS_NV"..0x8C81,
        "ACTIVE_VARYING_MAX_LENGTH_NV"..0x8C82,
        "TRANSFORM_FEEDBACK_VARYINGS_NV"..0x8C83
    )

    IntConstant(
        "Accepted by the {@code pname} parameter of GetBooleanv, GetDoublev, GetIntegerv, GetFloatv, and GetProgramiv.",

        "TRANSFORM_FEEDBACK_BUFFER_MODE_NV"..0x8C7F
    )

    IntConstant(
        "Accepted by the {@code attribs} parameter of TransformFeedbackAttribsNV.",

        "BACK_PRIMARY_COLOR_NV"..0x8C77,
        "BACK_SECONDARY_COLOR_NV"..0x8C78,
        "TEXTURE_COORD_NV"..0x8C79,
        "CLIP_DISTANCE_NV"..0x8C7A,
        "VERTEX_ID_NV"..0x8C7B,
        "PRIMITIVE_ID_NV"..0x8C7C,
        "GENERIC_ATTRIB_NV"..0x8C7D,
        "SECONDARY_COLOR_NV"..0x852D,
        "LAYER_NV"..0x8DAA
    )

    void(
        "BeginTransformFeedbackNV",
        "",

        GLenum.IN("primitiveMode", "")
    )

    void(
        "EndTransformFeedbackNV",
        ""
    )

    void(
        "TransformFeedbackAttribsNV",
        "",

        AutoSize("attribs")..GLsizei.IN("count", ""),
        const..GLint_p.IN("attribs", ""),
        GLenum.IN("bufferMode", "")
    )

    void(
        "BindBufferRangeNV",
        "",

        GLenum.IN("target", ""),
        GLuint.IN("index", ""),
        GLuint.IN("buffer", ""),
        GLintptr.IN("offset", ""),
        GLsizeiptr.IN("size", "")
    )

    void(
        "BindBufferOffsetNV",
        "",

        GLenum.IN("target", ""),
        GLuint.IN("index", ""),
        GLuint.IN("buffer", ""),
        GLintptr.IN("offset", "")
    )

    void(
        "BindBufferBaseNV",
        "",

        GLenum.IN("target", ""),
        GLuint.IN("index", ""),
        GLuint.IN("buffer", "")
    )

    void(
        "TransformFeedbackVaryingsNV",
        "",

        GLuint.IN("program", ""),
        AutoSize("locations")..GLsizei.IN("count", ""),
        const..GLint_p.IN("locations", ""),
        GLenum.IN("bufferMode", "")
    )

    void(
        "ActiveVaryingNV",
        "",

        GLuint.IN("program", ""),
        const..GLcharASCII_p.IN("name", "")
    )

    GLint(
        "GetVaryingLocationNV",
        "",

        GLuint.IN("program", ""),
        const..GLcharASCII_p.IN("name", "")
    )

    void(
        "GetActiveVaryingNV",
        "",

        GLuint.IN("program", ""),
        GLuint.IN("index", ""),
        AutoSize("name")..GLsizei.IN("bufSize", ""),
        nullable..Check(1)..GLsizei_p.OUT("length", ""),
        Check(1)..GLsizei_p.OUT("size", ""),
        Check(1)..GLenum_p.OUT("type", ""),
        GLcharASCII_p.OUT("name", "")
    )

    void(
        "GetTransformFeedbackVaryingNV",
        "",

        GLuint.IN("program", ""),
        GLuint.IN("index", ""),
        ReturnParam..Check(1)..GLint_p.OUT("location", "")
    )

    void(
        "TransformFeedbackStreamAttribsNV",
        "",

        AutoSize("attribs")..GLsizei.IN("count", ""),
        const..GLint_p.IN("attribs", ""),
        AutoSize("bufstreams")..GLsizei.IN("nbuffers", ""),
        const..GLint_p.IN("bufstreams", ""),
        GLenum.IN("bufferMode", "")
    )
}