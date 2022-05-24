package com.cpl.tsl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpCodeEnum implements IResultCode {

    /**
     * 200
     * （成功）  服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。 
     */
    SUCCESS(HttpCode.SUCCESS,"服务器已成功处理了请求。 通常，这表示服务器提供了请求的网页。"),
    /**
     * 201
     * （已创建）  请求成功并且服务器创建了新的资源。 
     */
    BUILD_SUCCESS(HttpCode.BUILD_SUCCESS,"请求成功并且服务器创建了新的资源。"),
    /**
     * 202
     * （已接受）  服务器已接受请求，但尚未处理。
     */
    ACCEPTED_SUCCESS(HttpCode.ACCEPTED_SUCCESS,"服务器已接受请求，但尚未处理。"),
    /**
     * 203
     * （非授权信息）  服务器已成功处理了请求，但返回的信息可能来自另一来源。 
     */
    UNAUTHORIZED_INFORMATION_SUCCESS(HttpCode.UNAUTHORIZED_INFORMATION_SUCCESS,"服务器已成功处理了请求，但返回的信息可能来自另一来源。 "),
    /**
     * 204
     * （无内容）  服务器成功处理了请求，但没有返回任何内容。 
     */
    NO_CONTENT_SUCCESS(HttpCode.NO_CONTENT_SUCCESS,"服务器成功处理了请求，但没有返回任何内容。"),
    /**
     * 205
     * （重置内容） 服务器成功处理了请求，但没有返回任何内容。 
     */
    REPETITION_SUCCESS(HttpCode.REPETITION_SUCCESS,"服务器成功处理了请求，但没有返回任何内容。 "),
    /**
     * 206
     * （部分内容）  服务器成功处理了部分 GET 请求。
     */
    PART_SUCCESS(HttpCode.PART_SUCCESS,"服务器成功处理了部分 GET 请求。"),
    /**
     * 300
     * （多种选择） 针对请求，服务器可执行多种操作。 服务器可根据请求者 (user agent) 选择一项操作，或提供操作列表供请求者选择。
     */
    MULTIPLE_CHOICES_ERROR(HttpCode.MULTIPLE_CHOICES_ERROR,"服务器可根据请求者 (user agent) 选择一项操作，或提供操作列表供请求者选择"),

    /**
     * 301
     * （永久移动） 请求的网页已永久移动到新位置。 服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。
     */
    MOVED_PERMANENTLY_ERROR(HttpCode.MOVED_PERMANENTLY_ERROR,"服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置"),

    /**
     * 302
     * （临时移动） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。
     */
    MOVE_ERROR(HttpCode.MOVE_ERROR,"服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求"),

    /**
     * 303
     * （查看其他位置） 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码。
     */
    PARAM_ERROR(HttpCode.PARAM_ERROR,"请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码"),

    /**
     * 304
     * （未修改） 自从上次请求后，请求的网页未修改过。 服务器返回此响应时，不会返回网页内容。
     */
    NO_REPAIR_ERROR(HttpCode.NO_REPAIR_ERROR,"自从上次请求后，请求的网页未修改过。 服务器返回此响应时，不会返回网页内容。"),

    /**
     * 305
     * （使用代理） 请求者只能使用代理访问请求的网页。 如果服务器返回此响应，还表示请求者应使用代理。
     */
    AGENT_ERROR(HttpCode.AGENT_ERROR,"（使用代理） 请求者只能使用代理访问请求的网页。 如果服务器返回此响应，还表示请求者应使用代理。"),

    /**
     * 307
     * (临时重定向）服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。
     */
    REDIRECT_ERROR(HttpCode.REDIRECT_ERROR,"(临时重定向）服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。"),

    /**
     * 400
     * （错误请求） 服务器不理解请求的语法。
     */
    BAD_REQUIRED_ERROR(HttpCode.BAD_REQUIRED_ERROR,"（错误请求） 服务器不理解请求的语法。"),

    /**
     * 401
     * （未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。 
     */
    UNAUTHORIZED_ERROR(HttpCode.UNAUTHORIZED_ERROR,"（未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。"),

    /**
     * 403
     * （禁止） 服务器拒绝请求。
     */
    FORBIDDEN_ERROR(HttpCode.FORBIDDEN_ERROR,"（禁止） 服务器拒绝请求。"),

    /**
     * 404
     * （未找到）服务器找不到请求的网页。
     */
    NOT_FOUND_ERROR(HttpCode.NOT_FOUND_ERROR,"（未找到）服务器找不到请求的网页。"),

    /**
     * 405
     * （方法禁用）禁用请求中指定的方法。 
     */
    DISABLE_ERROR(HttpCode.DISABLE_ERROR,"（方法禁用）禁用请求中指定的方法。 "),

    /**
     * 406
     * （不接受）无法使用请求的内容特性响应请求的网页。 
     */
    REJECT_ERROR(HttpCode.REJECT_ERROR,"（不接受）无法使用请求的内容特性响应请求的网页。"),

    /**
     * 407
     * （需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。
     */
    NEED_AGENCY_ERROR(HttpCode.NEED_AGENCY_ERROR,"（需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。"),

    /**
     * 408
     * （请求超时）服务器等候请求时发生超时。
     */
    TIMEOUT_ERROR(HttpCode.TIMEOUT_ERROR,"（请求超时）服务器等候请求时发生超时。"),

    /**
     * 409
     * （冲突）服务器在完成请求时发生冲突。 服务器必须在响应中包含有关冲突的信息。
     */
    CLASH_ERROR(HttpCode.CLASH_ERROR,"（冲突）服务器在完成请求时发生冲突。服务器必须在响应中包含有关冲突的信息。"),

    /**
     * 410
     * （已删除）如果请求的资源已永久删除，服务器就会返回此响应。 
     */
    REMOVE_ERROR(HttpCode.REMOVE_ERROR,"（已删除）如果请求的资源已永久删除，服务器就会返回此响应。"),

    /**
     * 411
     * （需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。
     */
    LENGTH_REQUIRE_ERROR(HttpCode.LENGTH_REQUIRE_ERROR,"（需要有效长度）服务器不接受不含有效内容长度标头字段的请求。"),

    /**
     * 412
     * （未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。
     */
    CONDITION_ERROR(HttpCode.CONDITION_ERROR,"（未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。"),

    /**
     * 413
     * （请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。
     */
    OVERLOAD_ERROR(HttpCode.OVERLOAD_ERROR,"（请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。"),

    /**
     * 414
     * （请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。
     */
    LENGTH_ERROR(HttpCode.LENGTH_ERROR,"（请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。"),

    /**
     * 415
     * （不支持的媒体类型） 请求的格式不受请求页面的支持。
     */
    UNSUPPORTED_ERROR(HttpCode.UNSUPPORTED_ERROR,"（不支持的媒体类型） 请求的格式不受请求页面的支持。"),

    /**
     * 416
     * （请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。
     */
    NOT_SATISFIABLE_ERROR(HttpCode.NOT_SATISFIABLE_ERROR,"（请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。"),

    /**
     * 417
     * （未满足期望值） 服务器未满足"期望"请求标头字段的要求。
     */
    NO_EXPECTATIONS_ERROR(HttpCode.NO_EXPECTATIONS_ERROR,"（未满足期望值） 服务器未满足期望请求标头字段的要求。"),

    /**
     * 500
     * （服务器内部错误）服务器遇到错误，无法完成请求。 
     */
    INTERNAL_SERVER_ERROR(HttpCode.INTERNAL_SERVER_ERROR,"（服务器内部错误）服务器遇到错误，无法完成请求。"),

    /**
     * 501
     * （尚未实施） 服务器不具备完成请求的功能。 例如，服务器无法识别请求方法时可能会返回此代码。 
     */
    UNKNOWN_ERROR(HttpCode.UNKNOWN_ERROR,"（尚未实施） 服务器不具备完成请求的功能。 例如，服务器无法识别请求方法时可能会返回此代码。"),

    /**
     * 502
     * （错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。
     */
    BAD_GATEWAY_ERROR(HttpCode.BAD_GATEWAY_ERROR,"（错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。"),

    /**
     * 503
     * （服务不可用） 服务器目前无法使用（由于超载或停机维护）。 通常，这只是暂时状态。
     */
    NO_SERVER_ERROR(HttpCode.NO_SERVER_ERROR,"（服务不可用） 服务器目前无法使用（由于超载或停机维护）。 通常，这只是暂时状态。"),

    /**
     * 504
     * （网关超时）服务器作为网关或代理，但是没有及时从上游服务器收到请求。
     */
    GATEWAY_TIMEOUT_ERROR(HttpCode.GATEWAY_TIMEOUT_ERROR,"（网关超时）服务器作为网关或代理，但是没有及时从上游服务器收到请求。"),

    /**
     * 505
     * （HTTP 版本不受支持）服务器不支持请求中所用的 HTTP 协议版本。
     */
    HTTP_VERSION_ERROR(HttpCode.HTTP_VERSION_ERROR,"（HTTP 版本不受支持）服务器不支持请求中所用的 HTTP 协议版本。"),
    /**
     * Swagger内部错误
     */
    SWAGGER_ERROR(HttpCode.SWAGGER_ERROR,"Swagger内部错误。");
    /**
     * code编码
     */
    final int code;
    /**
     * 中文信息描述
     */
    final String msg;
}
