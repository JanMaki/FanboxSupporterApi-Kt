package net.simpletimer.fanbox_supporter_api.data.relationships

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder


/**
 * [StatusType]の[KSerializer]
 *
 */
class StatusTypeSerializer : KSerializer<StatusType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("FilterOptionType", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: StatusType) {
        encoder.encodeString(value.apiValue)
    }

    override fun deserialize(decoder: Decoder): StatusType {
        val text = decoder.decodeString()
        return StatusType.getOptionTypeFromAPIValue(text)
    }
}